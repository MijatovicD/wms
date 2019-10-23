import { ReportService } from './../service/report.service';
import { ProductCardService } from './../service/productCard.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { BsDatepickerConfig } from 'ngx-bootstrap';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {

  sub: Subscription;
  izvestajForm: FormGroup;
  bsConfig: Partial<BsDatepickerConfig>;
  card: any;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private cardService: ProductCardService,
    private reportService: ReportService,
    ) { }

  ngOnInit() {
    this.bsConfig = {
      containerClass: 'theme-default'
    };
    this.createReportForm();
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.cardService.getId(id).subscribe((c: any) => {
          if (c) {
            console.log(c);
            this.card = c;
          } else {
          }
        });
      }
    });
  }

  createReportForm() {
    this.izvestajForm = this.fb.group({
      datumPocetni: [null, Validators.required],
      datumKrajnji: [null, Validators.required],
    });
  }

  onSubmit() {
    const datumPocetniVal = this.izvestajForm.controls.datumPocetni.value;
    const datumKrajnjiVal = this.izvestajForm.controls.datumKrajnji.value;
    const datumPocetniStr = this.getFormattedDate(datumPocetniVal);
    const datumKrajnjiStr = this.getFormattedDate(datumKrajnjiVal);
    this.reportService.downloadAnalasyisReport(this.card.id, datumPocetniStr, datumKrajnjiStr);
  }

  getFormattedDate(date) {
    let year = date.getFullYear();
    let month = (1 + date.getMonth()).toString().padStart(2, '0');
    let day = date.getDate().toString().padStart(2, '0');
    return day + '-' + month + '-' + year;
}

}
