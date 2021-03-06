import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class YearService {

  private baseUrl = "http://localhost:8080/api/year";

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

  add(year): any{
    return this.http.post<any>(this.baseUrl, year);
  }

  zakljuci(year):any{
    return this.http.post<any>(this.baseUrl + "/zakljuci", year);
  }
}
