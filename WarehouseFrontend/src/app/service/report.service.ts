import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import {saveAs} from 'file-saver';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/report'; 


  downloadAnalasyisReport(karticaId: number, datumPocetni: string, datumKrajnji: string) {
    const headers = new HttpHeaders({
      'Accept': 'application/pdf'
    });

    let queryString = '?';

    queryString += 'cardId=' + karticaId + '&startDate=' + datumPocetni + '&endDate=' + datumKrajnji;

    this.http.get(this.baseUrl + "/analasysForCard"+ queryString,
      {observe: 'response', headers: headers, responseType: 'blob'})
      .subscribe(response => this.saveToFileSystem(response));
  }

  private saveToFileSystem(response) {
    console.log(response);
    const contentDispositionHeader: string = response.headers.get('Content-Disposition');
    const parts: string[] = contentDispositionHeader.split(';');
    let filename = parts[1].split('=')[1];
    filename = filename.split("\"")[1];
    console.log("filename: " + filename);
    const file = new File([response.body], filename, {type: 'application/pdf'});
    console.log(file);
    saveAs(file);
  }
}
