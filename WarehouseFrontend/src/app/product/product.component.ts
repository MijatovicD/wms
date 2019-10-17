import { ItemPage } from './../model/item.page.model';
import { ProductService } from './../service/product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  all:any[];
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  productCard:any[];

  constructor(
    private productService: ProductService
  ) { }

  ngOnInit() {
    this.getProductPage(0,9);
  }

  search(name):any{
    this.productService.search(name).subscribe(p =>{
        this.all = p;
    });
  }
  
  getProductPage(page: number, size:number) {
    this.productService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getProductPage(this.currentPage - 1, this.itemsPerPage);
  }

}
