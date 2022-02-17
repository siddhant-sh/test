import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrolledstudentlistComponent } from './enrolledstudentlist.component';

describe('EnrolledstudentlistComponent', () => {
  let component: EnrolledstudentlistComponent;
  let fixture: ComponentFixture<EnrolledstudentlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnrolledstudentlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrolledstudentlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
