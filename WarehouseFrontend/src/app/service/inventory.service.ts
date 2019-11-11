import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { map, catchError } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  private baseUrl = "http://localhost:8080/api/inventory";
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
      "http://localhost:8080/api/inventory/" + page + "/" + itemsPerPage
    );
  }

  getDokument(id): any {
    return this.http.get("http://localhost:8080/api/inventory/" + id);
  }

  addDokument(dokument): any {
    return this.http.post("http://localhost:8080/api/inventory", dokument);
  }

  proknjizi(dokument): any {
    return this.http
      .post("http://localhost:8080/api/inventory/proknjizi", dokument)
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
      "http://localhost:8080/api/inventory/storniraj",
      dokument
    );
  }

}
