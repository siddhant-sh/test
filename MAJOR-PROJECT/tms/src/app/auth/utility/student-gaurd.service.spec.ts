import { TestBed } from '@angular/core/testing';

import { StudentGaurdService } from './student-gaurd.service';

describe('StudentGaurdService', () => {
  let service: StudentGaurdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentGaurdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
