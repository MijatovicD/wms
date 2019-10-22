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
      this.analyticsService.findByProductCardId(this.cardId).subscribe(a =>{
          this.all = a;
      });
    });
  }

}
