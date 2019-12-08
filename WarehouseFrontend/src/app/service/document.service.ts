import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { map, catchError } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  private baseUrl = "http://localhost:8080/api/document";
  constructor(private http: HttpClient) {}

  getAllPaged(page: number, itemsPerPage: number) {
    let queryString = '?';

    if (page != null && itemsPerPage != null) {
      queryString += 'page=' + page + '&size=' + itemsPerPage;
    }

    return this.http.get<any>(this.baseUrl + queryString);
  }

  getAll(page: number, itemsPerPage: number): Observable<any> {
    return this.http.get(
      "http://localhost:8080/api/document/" + page + "/" + itemsPerPage
    );
  }

  getDokument(id): any {
    return this.http.get("http://localhost:8080/api/document/" + id);
  }

  addDokument(dokument): any {
    return this.http.post("http://localhost:8080/api/document", dokument);
  }

  addInterDocument(document):any{
    return this.http.post("http://localhost:8080/api/document/interWarehouse", document);
  }

  getInterItems(id):any{
    return this.http.get(this.baseUrl + "/" + id + "/interWarehouse");
  }

  proknjizi(dokument): any {
    return this.http
      .post("http://localhost:8080/api/document/proknjizi", dokument)
      .pipe(
        map((res: any) => {
          return res;
        }),
        catchError((error: any) => {
          if (error.status == 404) {
            alert("Zao nam je, nemamo robu u toj kolicini.");
          }
          return throwError(error || "Server error");
        })
      );
  }

  storniraj(dokument): any {
    return this.http.post(
      "http://localhost:8080/api/document/storniraj",
      dokument
    );
  }

}
