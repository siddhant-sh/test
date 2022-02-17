import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorMaterialComponent } from './tutor-material.component';

describe('TutorMaterialComponent', () => {
  let component: TutorMaterialComponent;
  let fixture: ComponentFixture<TutorMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorMaterialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
