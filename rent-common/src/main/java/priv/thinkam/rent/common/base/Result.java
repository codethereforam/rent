package priv.thinkam.rent.common.base;

/**
 * Created by thinkam on 12/17/17.
 */
public class Result {
	private boolean success;
	private Object data;

	public Result(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	public Result(boolean success) {
		this(success, null);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result{" +
				"success=" + success +
				", data=" + data +
				'}';
	}
}
