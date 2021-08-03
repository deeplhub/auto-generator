package com.xh.auto.generator.properties;

import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2021/8/2
 */
public class ScrewConfig {

    private String fileName;
    private String version;
    private String description;
    private String fileOutputDir;
    private Boolean open;
    private EngineFileType fileType;
    private EngineTemplateType produceType;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileOutputDir() {
        return fileOutputDir;
    }

    public void setFileOutputDir(String fileOutputDir) {
        this.fileOutputDir = fileOutputDir;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public EngineFileType getFileType() {
        return fileType;
    }

    public void setFileType(EngineFileType fileType) {
        this.fileType = fileType;
    }

    public EngineTemplateType getProduceType() {
        return produceType;
    }

    public void setProduceType(EngineTemplateType produceType) {
        this.produceType = produceType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
