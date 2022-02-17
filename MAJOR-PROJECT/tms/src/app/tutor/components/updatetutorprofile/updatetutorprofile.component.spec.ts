import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatetutorprofileComponent } from './updatetutorprofile.component';

describe('UpdatetutorprofileComponent', () => {
  let component: UpdatetutorprofileComponent;
  let fixture: ComponentFixture<UpdatetutorprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatetutorprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatetutorprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
