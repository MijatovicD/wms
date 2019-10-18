import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PartnerService {

  private baseUrl = "http://localhost:8080/api/partner";

  constructor(
    private http: HttpClient
  ) { }

  getAllPaged(page: number, itemsPerPage: number) {
    let queryString = '?';

    if (page != null && itemsPerPage != null) {
      queryString += 'page=' + page + '&size=' + itemsPerPage;
    }

    return this.http.get<any>(this.baseUrl + queryString);
  }

  getAll(): Observable<any[]>{
    return this.http.get<any[]>(this.baseUrl).pipe();
  }

  add(partner): any{
    return this.http.post<any>(this.baseUrl, partner);
  }

}
