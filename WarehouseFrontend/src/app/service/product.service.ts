import { Product } from './../model/product';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/product";

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

  add(product): any{
    return this.http.post<any>(this.baseUrl, product);
  }

  search(name): Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl + "/name/" + name);
  }

  getAll(): Observable<any[]>{
    return this.http.get<any[]>(this.baseUrl).pipe();
  }
}
