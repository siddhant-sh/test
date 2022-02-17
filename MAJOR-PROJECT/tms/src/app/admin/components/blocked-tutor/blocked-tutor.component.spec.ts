import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockedTutorComponent } from './blocked-tutor.component';

describe('BlockedTutorComponent', () => {
  let component: BlockedTutorComponent;
  let fixture: ComponentFixture<BlockedTutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlockedTutorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlockedTutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
