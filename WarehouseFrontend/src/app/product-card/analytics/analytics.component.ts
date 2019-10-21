import { ItemPage } from './../../model/item.page.model';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AnalyticsService } from './../../service/analytics.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.scss']
})
export class AnalyticsComponent implements OnInit {

  sub: Subscription;
  cardId:number;
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  all: any[];

  constructor(
    private analyticsService: AnalyticsService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.cardId = params['id'];
      this.getCardPage(0,3);
    });
  }


  getCardPage(page: number, size:number) {
    this.analyticsService.getAllPaged(page, size)
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
