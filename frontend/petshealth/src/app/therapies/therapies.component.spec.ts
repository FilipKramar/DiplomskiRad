import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TherapiesComponent } from './therapies.component';

describe('TherapiesComponent', () => {
  let component: TherapiesComponent;
  let fixture: ComponentFixture<TherapiesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TherapiesComponent]
    });
    fixture = TestBed.createComponent(TherapiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
