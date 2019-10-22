import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {

  private baseUrl = "http://localhost:8080/api/analytics";

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


  findByProductCardId(id):any{
    return this.http.get<any>(this.baseUrl + "/productCard/" + id);
  }

  getAllPagedForCard(id: number, page: number, itemsPerPage: number) {
    let queryString = '?';

    if (page != null && itemsPerPage != null) {
      queryString += 'page=' + page + '&size=' + itemsPerPage;
    }

    return this.http.get<any>(this.baseUrl + '/robnaKartica/' + id + queryString);
  }

}
