import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { map, catchError } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class InventoryItemService {

  private baseUrl = "http://localhost:8080/api/inventoryItem";
  constructor(private http: HttpClient) {}

  getAllPaged(page: number, itemsPerPage: number) {
    let queryString = '?';

    if (page != null && itemsPerPage != null) {
      queryString += 'page=' + page + '&size=' + itemsPerPage;
    }

    return this.http.get<any>(this.baseUrl + queryString);
  }

  getAll(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  saveItem(item): any {
    return this.http.post(
      this.baseUrl,
      item
    );
  }

}
