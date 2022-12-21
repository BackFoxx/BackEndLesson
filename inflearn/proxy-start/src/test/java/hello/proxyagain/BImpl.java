package hello.proxyagain;

import javax.validation.constraints.Max;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface {

	@Max(4)
	private String max;


	@Override
	public String call() {
		log.info("B 호출");
		return "b";
	}
}
