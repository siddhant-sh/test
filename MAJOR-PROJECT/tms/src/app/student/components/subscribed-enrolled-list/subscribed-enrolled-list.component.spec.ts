import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedEnrolledListComponent } from './subscribed-enrolled-list.component';

describe('SubscribedEnrolledListComponent', () => {
  let component: SubscribedEnrolledListComponent;
  let fixture: ComponentFixture<SubscribedEnrolledListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribedEnrolledListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedEnrolledListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
