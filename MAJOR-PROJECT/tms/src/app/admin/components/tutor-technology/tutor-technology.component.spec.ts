import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorTechnologyComponent } from './tutor-technology.component';

describe('TutorTechnologyComponent', () => {
  let component: TutorTechnologyComponent;
  let fixture: ComponentFixture<TutorTechnologyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorTechnologyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorTechnologyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
