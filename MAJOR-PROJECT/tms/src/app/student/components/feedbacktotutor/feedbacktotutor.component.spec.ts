import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbacktotutorComponent } from './feedbacktotutor.component';

describe('FeedbacktotutorComponent', () => {
  let component: FeedbacktotutorComponent;
  let fixture: ComponentFixture<FeedbacktotutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedbacktotutorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbacktotutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
