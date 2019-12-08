import { BussinesYear } from './../model/bussinesYear';
import { YearService } from './../service/year.service';
import { ItemPage } from './../model/item.page.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bussines-year',
  templateUrl: './bussines-year.component.html',
  styleUrls: ['./bussines-year.component.css']
})
export class BussinesYearComponent implements OnInit {

  all: any[];
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  bussinessYear: BussinesYear;
  year:string;
  bussinesYear = {
    id: null,
    year: null,
    isClosed: false
  };

  constructor(
    private yearService: YearService
  ) { }

  ngOnInit() {
    this.getYearPage(0,3);
  }

  addYear(){
    this.bussinessYear = new BussinesYear(0, this.year);

    this.yearService.add(this.bussinessYear).subscribe(y => {

    });
  }

  getYearPage(page: number, size:number) {
    this.yearService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getYearPage(this.currentPage - 1, this.itemsPerPage);
  }

  closeYear(year){
    this.bussinesYear.id = year;
    this.yearService.zakljuci(this.bussinesYear).subscribe(res =>{
      console.log(res);
    });
  }
}
