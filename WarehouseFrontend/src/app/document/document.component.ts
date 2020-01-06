import { ItemPage } from './../model/item.page.model';
import { DocumentService } from './../service/document.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css']
})
export class DocumentComponent implements OnInit {

  dokPage = { size: null };
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  all;

  constructor(private documentService: DocumentService) {}

  ngOnInit() {
    this.getDocumentPage(0, 3);
  }

 
  getDocumentPage(page: number, size:number) {
    this.documentService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getDocumentPage(this.currentPage - 1, this.itemsPerPage);
  }
}
