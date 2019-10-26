import { Injectable } from "@angular/core";
import { CanActivate, Router } from "@angular/router";

@Injectable({
  providedIn: "root"
})
export class LoggedInGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate() {
    if (localStorage.getItem("userInfo")) {
      this.router.navigate(["/"]);
      return false;
    }
    return true;
  }
}
