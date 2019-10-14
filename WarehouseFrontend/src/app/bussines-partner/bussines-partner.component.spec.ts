import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BussinesPartnerComponent } from './bussines-partner.component';

describe('BussinesPartnerComponent', () => {
  let component: BussinesPartnerComponent;
  let fixture: ComponentFixture<BussinesPartnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BussinesPartnerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BussinesPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
