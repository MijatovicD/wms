import { ProductGroupService } from './../service/productGroup.service';
import { ItemPage } from './../model/item.page.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-group',
  templateUrl: './product-group.component.html',
  styleUrls: ['./product-group.component.scss']
})
export class ProductGroupComponent implements OnInit {

  all;
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;

  constructor(private groupService: ProductGroupService ) { }

  ngOnInit() {
    this.getCardPage(0,3);    
  }

  getCardPage(page: number, size:number) {
    this.groupService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getCardPage(this.currentPage - 1, this.itemsPerPage);
  }

}
