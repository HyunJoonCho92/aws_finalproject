package dbsecure;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration //내가 설정한 클래스입니다.
@EnableEncryptableProperties // 현재 정보를 application.properties파일에서 사용 가능
public class DBConfig {
	
	@Bean("jasyptEncryptor") // 라이브러리가 사용한 것을 빈으로 만들어줘
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("DB_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        
        System.out.println("===DBConfig 출력===");
        System.out.println(System.getenv("DB_PASSWORD"));
        System.out.println(encryptor.decrypt("ZU0p3S7uMeMvRvpz3jzXTIWnhOSCvqoXuJEla6Y3cWM="));
        System.out.println(encryptor.decrypt("by58fVZ86im77YcEfYs4VrrqH+Dg7bjZ2/onK5Ko8vZ+Pm+PcQWuqLxj1OOz7FJe3p0+L5qh9HWUfSAVXLg4dzXG9fxCJtcxyJtH9o7o466expdNSAhftIlzN4DXk197QZrCiojYkCo="));
        System.out.println(encryptor.decrypt("3mCs9DR45U+VWiSFppNG39M5rrCkVTtn"));
        System.out.println(encryptor.decrypt("HimmcJOw+RaemNq5p1lXoNln+H6mVEjP"));
        
        return encryptor;
	}
}