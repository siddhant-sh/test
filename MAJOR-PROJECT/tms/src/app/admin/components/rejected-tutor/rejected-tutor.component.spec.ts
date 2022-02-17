import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RejectedTutorComponent } from './rejected-tutor.component';

describe('RejectedTutorComponent', () => {
  let component: RejectedTutorComponent;
  let fixture: ComponentFixture<RejectedTutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RejectedTutorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RejectedTutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
