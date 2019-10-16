import { BussinesPartner } from './../model/bussinesPartner';
import { Component, OnInit } from '@angular/core';
import { PartnerService } from '../service/partner.service';
import { ItemPage } from '../model/item.page.model';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-bussines-partner',
  templateUrl: './bussines-partner.component.html',
  styleUrls: ['./bussines-partner.component.css']
})
export class BussinesPartnerComponent implements OnInit {

  all:any[];
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  partner: BussinesPartner;
  name:string;
  pib:string;
  address:string;

  constructor(
    private partnerService: PartnerService
    ) { }

  ngOnInit() {
   

    this.getPartnerPage(0,3);
  }

  addPartner(){
    this.partner = new BussinesPartner(0, this.name, this.pib, this.address);

    this.partnerService.add(this.partner).subscribe(p => {
      

    });
  }

  getPartnerPage(page: number, size:number) {
    this.partnerService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getPartnerPage(this.currentPage - 1, this.itemsPerPage);
  }

}