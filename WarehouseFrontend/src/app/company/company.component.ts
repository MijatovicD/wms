import { CompanyService } from './../service/company.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  svi;
  currentPage: number;
  itemsPerPage: number;


  constructor(
    private companyService: CompanyService
  ) { }

  ngOnInit() {
    console.log("hfdskhka");
    this.getCompanyPage(0,3);
  }


  getCompanyPage(page: number, size:number) {
    this.companyService.getAllPaged(page, size)
      .subscribe(page => {
        this.svi = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getCompanyPage(this.currentPage - 1, this.itemsPerPage);
  }

}
