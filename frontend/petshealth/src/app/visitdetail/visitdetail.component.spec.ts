import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitdetailComponent } from './visitdetail.component';

describe('VisitdetailComponent', () => {
  let component: VisitdetailComponent;
  let fixture: ComponentFixture<VisitdetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VisitdetailComponent]
    });
    fixture = TestBed.createComponent(VisitdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
