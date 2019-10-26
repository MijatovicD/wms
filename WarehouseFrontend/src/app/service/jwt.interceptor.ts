import { Injectable, Injector } from "@angular/core";
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest
} from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(private inj: Injector) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (localStorage.getItem("token")) {
      request = request.clone({
        setHeaders: {
          authorization: localStorage.getItem("token"),
          enctype: "multipart/form-data"
        }
      });
    }
    console.log(request);
    return next.handle(request);
  }
}
