import { ItemPage } from './../model/item.page.model';
import { UnitService } from './../service/unit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.css']
})
export class UnitComponent implements OnInit {

  all: any[];

  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;



  constructor(
    private unitService: UnitService,
    ) { }

  ngOnInit() {
    this.getUnitPage(0,3);
  }


  getUnitPage(page: number, size:number) {
    this.unitService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getUnitPage(this.currentPage - 1, this.itemsPerPage);
  }

}
