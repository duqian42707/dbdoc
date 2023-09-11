import {HttpResponse} from "@angular/common/http";

/**
 * 根据http请求的返回值进行下载
 *
 */
export function downloadFromResponse(resp: HttpResponse<Blob>): void {
  let filename = '数据导出.xlsx';
  // 尝试从响应头中解析出文件名
  const disposition = resp.headers.get('content-disposition');
  if (disposition) {
    const filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
    const matches = filenameRegex.exec(disposition);
    if (matches != null && matches[1]) {
      filename = matches[1].replace(/['"]/g, '');
      filename = decodeURIComponent(filename);
    }
  }
  if (resp.body) {
    const blob = new Blob([resp.body]);
    const a = document.createElement('a');
    document.body.appendChild(a);
    a.download = filename;
    a.href = URL.createObjectURL(blob);
    a.click();
  }
}
