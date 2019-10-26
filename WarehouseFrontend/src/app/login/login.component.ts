import { throwError } from 'rxjs';
import { Router } from '@angular/router';
import { LoginService } from './../service/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  private user: any = {};
  private badLogin: any = false;
  thisPage = "loginPage";
  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {}

  login(): void {
    if (this.user.username == null || this.user.password == null) {
      this.badLogin = true;
    } else {
      console.log(this.user);
      this.loginService.login(this.user).subscribe(
        (res: boolean) => {
          console.log(res);
          if (res) {
            this.router.navigate(["/product"]);
          }
        },
        (err: Error) => {
          if (err.toString() === "Unauthorized") {
            console.log("Unauthorized");
            this.badLogin = true;
          } else {
            throwError(err);
          }
        }
      );
    }
  }
}
