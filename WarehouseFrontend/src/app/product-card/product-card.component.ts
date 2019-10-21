import { ProductCardService } from './../service/productCard.service';
import { ItemPage } from './../model/item.page.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss']
})
export class ProductCardComponent implements OnInit {

  all;
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;

  constructor(private cardService: ProductCardService ) { }

  ngOnInit() {
    this.getCardPage(0,3);    
  }

  getCardPage(page: number, size:number) {
    this.cardService.getAllPaged(page, size)
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
