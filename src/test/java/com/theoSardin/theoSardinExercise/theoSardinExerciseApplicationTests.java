package com.theoSardin.theoSardinExercise;

import com.theoSardin.theoSardinExercise.domain.DataProvidingService;
import com.theoSardin.theoSardinExercise.domain.MyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class theoSardinExerciseApplicationTests {

	@Mock
	DataProvidingService dataProvidingService;

	@Mock
	HttpClientErrorException httpClientErrorException;

	@InjectMocks
	@Spy
	MyServiceImpl myService;


	@Before
	public void initMocks() {
		when(httpClientErrorException.getRawStatusCode()).thenReturn(404);
		when(dataProvidingService.getData()).thenThrow(httpClientErrorException);
	}

	@Test
	public void doSomethingThatCallsDataProvidingServiceTest(){
		myService.doSomethingThatCallsDataProvidingService();
		verify(myService,times(1)).doSomethingOn404();
	}
}
