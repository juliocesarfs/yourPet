package utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Return {
	private boolean sucess;
	private String message;
	private Object value;
}
