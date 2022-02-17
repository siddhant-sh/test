import { TestBed } from '@angular/core/testing';

import { FeedbacktotutorService } from './feedbacktotutor.service';

describe('FeedbacktotutorService', () => {
  let service: FeedbacktotutorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeedbacktotutorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
