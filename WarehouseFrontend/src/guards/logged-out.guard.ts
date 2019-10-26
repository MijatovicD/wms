import { Injectable } from "@angular/core";
import { CanActivate, Router } from "@angular/router";

@Injectable({
  providedIn: "root"
})
export class LoggedOutGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate() {
    if (!localStorage.getItem("userInfo")) {
      this.router.navigate(["/login"]);
      return false;
    }
    return true;
  }
}
