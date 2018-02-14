package io.qameta.allure.suites;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import io.qameta.allure.entity.TestResult;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class contains the information for the suites csv export.
 */
public class CsvExportSuite implements Serializable {

    private static final long serialVersionUID = 1L;

    @CsvBindByName(column = "Status")
    @CsvBindByPosition(position = 0)
    private final String status;

    @CsvBindByName(column = "Name")
    @CsvBindByPosition(position = 1)
    private final String name;

    @CsvBindByName(column = "Duration in ms")
    @CsvBindByPosition(position = 2)
    private final String duration;

    @CsvBindByName(column = "Description")
    @CsvBindByPosition(position = 3)
    private final String message;

    public CsvExportSuite(final TestResult result) {
        this.status = result.getStatus() != null ? result.getStatus().value() : null;
        this.name = result.getFullName();
        this.duration = Objects.isNull(result.getDuration()) ? null : Objects.toString(result.getDuration());
        this.message = result.getDescription();
    }

    public String getMessage() {
        return message;
    }

    public String getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}