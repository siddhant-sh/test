import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentlistApprovalComponent } from './studentlist-approval.component';

describe('StudentlistApprovalComponent', () => {
  let component: StudentlistApprovalComponent;
  let fixture: ComponentFixture<StudentlistApprovalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentlistApprovalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentlistApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
