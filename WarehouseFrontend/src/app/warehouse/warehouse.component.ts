import { ReportService } from './../service/report.service';
import { ItemPage } from './../model/item.page.model';
import { WarehouseSerice } from './../service/warehouse.service';
import { Component, OnInit } from '@angular/core';
import { ProductCardService } from '../service/productCard.service';

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss']
})
export class WarehouseComponent implements OnInit {

  all:any[];
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  name:string;

  constructor(private warehouseService: WarehouseSerice, private productCardService: ProductCardService, private reporstService: ReportService) { }

  ngOnInit() {
    this.getWarehousePage(0,3);
  }

  addYear(){

    // this.warehouseService.add(this.bussinessYear).subscribe(y => {

    // });
  }

  getWarehousePage(page: number, size:number) {
    this.warehouseService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getWarehousePage(this.currentPage - 1, this.itemsPerPage);
  }

  lager(id){
    this.productCardService.getCardsByWarehouse(id).subscribe(res =>{
        this.reporstService.downloadLager(id);
    });
  }
}
