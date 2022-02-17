import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedtutorsComponent } from './approvedtutors.component';

describe('ApprovedtutorsComponent', () => {
  let component: ApprovedtutorsComponent;
  let fixture: ComponentFixture<ApprovedtutorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApprovedtutorsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprovedtutorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
