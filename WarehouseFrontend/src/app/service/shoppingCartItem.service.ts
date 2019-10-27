import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartItemService {

  private baseUrl = "http://localhost:8080/api/cartItem";

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

  add(cart): any{
    console.log(cart);
    return this.http.post<any>(this.baseUrl, cart);
  }
  
  findByUserId(username){
    return this.http.get(this.baseUrl + "/user/" + username);
  }

}
