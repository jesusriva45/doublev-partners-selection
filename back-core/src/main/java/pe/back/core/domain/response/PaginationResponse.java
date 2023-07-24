package pe.back.core.domain.response;

public class PaginationResponse<T> {

    Integer totalElementByPage;

    Integer totalElements;
    T response;

    public Integer getTotalElementByPage() {
        return totalElementByPage;
    }

    public void setTotalElementByPage(Integer totalElementByPage) {
        this.totalElementByPage = totalElementByPage;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
