import { TestBed } from '@angular/core/testing';

import { TutorGaurdService } from './tutor-gaurd.service';

describe('TutorGaurdService', () => {
  let service: TutorGaurdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TutorGaurdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
