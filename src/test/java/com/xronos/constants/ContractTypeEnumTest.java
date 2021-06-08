package com.xronos.constants;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ContractTypeEnumTest {

  @Test
  public void testContractTypeEnum() {
    log.info(ContractTypeEnum.CW.name());
    log.info(ContractTypeEnum.valueOf("CW").value);
    log.info(ContractTypeEnum.valueOf("CW").name());
  }
}