import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DocumentItemService {

  private baseUrl = "http://localhost:8080/api/warehouse";

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

  findByProductId(id):any{
    return this.http.get<any>(this.baseUrl + "/product/" + id);
  }

  getStavke(id): Observable<any> {
    return this.http.get(
      "http://localhost:8080/api/dokumenti/dokument/" + id + "/stavke"
    );
  }

  saveStavka(stavka): any {
    return this.http.post(
      "http://localhost:8080/api/stavkadokumenta/create",
      stavka
    );
  }
}
