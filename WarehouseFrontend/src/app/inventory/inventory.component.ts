import { InventoryService } from './../service/inventory.service';
import { ItemPage } from './../model/item.page.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.scss']
})
export class InventoryComponent implements OnInit {
  dokPage = { size: null };
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  all;

  constructor(private inventortService: InventoryService) {}

  ngOnInit() {
    this.getInventoryPage(0, 3);
  }

 
  getInventoryPage(page: number, size:number) {
    this.inventortService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getInventoryPage(this.currentPage - 1, this.itemsPerPage);
  }
}
