import { AnalyticsComponent } from './../analytics/analytics.component';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductCardService } from './../../service/productCard.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-product-card-detail',
  templateUrl: './product-card-detail.component.html',
  styleUrls: ['./product-card-detail.component.scss']
})
export class ProductCardDetailComponent implements OnInit {
  
  sub: Subscription;
  card: any;
  id: number;
  nivelacijaPokusana: boolean;


  @ViewChild(AnalyticsComponent)
  private analytics: AnalyticsComponent;

  constructor(private cardSerice: ProductCardService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.id = id;
        this.loadCard(id);
      }
    });
  }

  loadCard(id: number) {
    this.cardSerice.getId(id).subscribe((k: any) => {
      if (k) {
        console.log(k);
        this.card = k;
      } else {

      }
    });
  }

  nivelacija() {
    this.cardSerice.nivelacija(this.card.id).subscribe(res => {
      if (res == true) {
        this.loadCard(this.id);
        this.analytics.ngOnInit();
      }
      this.nivelacijaPokusana = true;
      console.log(res);
    });
   }

}
